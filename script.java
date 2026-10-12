document.addEventListener('DOMContentLoaded', () => {
    const photoInput = document.getElementById('photo-input');
    const dropZone = document.getElementById('drop-zone');
    const previewContainer = document.getElementById('preview-container');
    const canvas = document.getElementById('photo-canvas');
    const ctx = canvas.getContext('2d');
    const filterBtns = document.querySelectorAll('.btn-filter');
    const downloadBtn = document.getElementById('download-btn');

    let currentImage = new Image();
    let currentFilter = 'cyberpunk';

    // Gestion du drag and drop / upload
    dropZone.addEventListener('click', () => photoInput.click());
    
    dropZone.addEventListener('dragover', (e) => {
        e.preventDefault();
        dropZone.style.borderColor = 'var(--accent-cyan)';
    });

    dropZone.addEventListener('dragleave', () => {
        dropZone.style.borderColor = 'var(--card-border)';
    });

    dropZone.addEventListener('drop', (e) => {
        e.preventDefault();
        dropZone.style.borderColor = 'var(--card-border)';
        if (e.dataTransfer.files && e.dataTransfer.files[0]) {
            handleImageFile(e.dataTransfer.files[0]);
        }
    });

    photoInput.addEventListener('change', (e) => {
        if (e.target.files && e.target.files[0]) {
            handleImageFile(e.target.files[0]);
        }
    });

    function handleImageFile(file) {
        const reader = new FileReader();
        reader.onload = (event) => {
            currentImage.src = event.target.result;
            currentImage.onload = () => {
                dropZone.style.display = 'none';
                previewContainer.style.display = 'flex';
                applyFiltersAndDraw();
            }
        }
        reader.readAsDataURL(file);
    }

    // Gestion des filtres
    filterBtns.forEach(btn => {
        btn.addEventListener('click', () => {
            filterBtns.forEach(b => b.classList.remove('active'));
            btn.classList.add('active');
            currentFilter = btn.getAttribute('data-filter');
            applyFiltersAndDraw();
        });
    });

    // Application des filtres graphiques sur le Canvas
    function applyFiltersAndDraw() {
        if (!currentImage.src) return;

        // Redimensionnement proportionnel max 600px
        let maxWidth = 500;
        let scaleFactor = maxWidth / currentImage.width;
        canvas.width = maxWidth;
        canvas.height = currentImage.height * scaleFactor;

        // Dessiner l'image originale
        ctx.drawImage(currentImage, 0, 0, canvas.width, canvas.height);

        // Obtenir les pixels pour manipulation couleur
        let imgData = ctx.getImageData(0, 0, canvas.width, canvas.height);
        let data = imgData.data;

        for (let i = 0; i < data.length; i += 4) {
            let r = data[i];
            let g = data[i + 1];
            let b = data[i + 2];

            if (currentFilter === 'cyberpunk') {
                // Boost cyan/magenta & contraste sombre
                data[i] = Math.min(255, r * 1.1 + 20);     // Rouge un peu chaud
                data[i + 1] = Math.min(255, g * 0.9);      // Vert baissé
                data[i + 2] = Math.min(255, b * 1.4 + 40); // Cyan boosté
            } else if (currentFilter === 'matrix') {
                // Teinte vert terminal
                let avg = (r + g + b) / 3;
                data[i] = avg * 0.2;
                data[i + 1] = Math.min(255, avg * 1.6);
                data[i + 2] = avg * 0.2;
            } else if (currentFilter === 'noir') {
                // Noir et blanc contrasté high-tech
                let avg = (r * 0.3 + g * 0.59 + b * 0.11);
                let contrast = 1.3;
                let adjusted = clamp(((avg - 128) * contrast) + 128);
                data[i] = adjusted;
                data[i + 1] = adjusted;
                data[i + 2] = adjusted;
            }
        }

        ctx.putImageData(imgData, 0, 0);

        // Ajouter un léger effet de vignette sombre sur les bords
        let gradient = ctx.createRadialGradient(
            canvas.width / 2, canvas.height / 2, canvas.width / 4,
            canvas.width / 2, canvas.height / 2, canvas.width / 1.2
        );
        gradient.addColorStop(0, 'rgba(0,0,0,0)');
        gradient.addColorStop(1, 'rgba(5, 8, 17, 0.8)');
        ctx.fillStyle = gradient;
        ctx.fillRect(0, 0, canvas.width, canvas.height);
    }

    function clamp(val) {
        return Math.max(0, Math.min(255, val));
    }

    // Bouton de téléchargement
    downloadBtn.addEventListener('click', () => {
        const link = document.createElement('a');
        link.download = `Leong-Yoane-${currentFilter}-avatar.png`;
        link.href = canvas.toDataURL('image/png');
        link.click();
    });
});
