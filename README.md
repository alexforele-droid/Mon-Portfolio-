# 👋 Bonjour, moi c'est RASOLONIRINA Leong-Yoane Stanislas !

### 🎓 Étudiant en Mathématiques & Informatique | 💻 Développement | 🔐 Cybersécurité

Je suis étudiant en **L2 Mathématiques & Informatique** à Madagascar, avec un intérêt particulier pour la **programmation**, les **mathématiques appliquées à l'informatique** et la **cybersécurité**.

Je construis progressivement mes compétences à travers des projets personnels, des exercices universitaires et l'expérimentation sur différents environnements.

> 💡 Mon objectif n'est pas seulement de faire fonctionner un programme, mais de comprendre **pourquoi et comment il fonctionne**.

---

## 🧑‍💻 À propos de moi

- 🎓 **L2 Mathématiques & Informatique**
- 🇲🇬 Basé à **Madagascar**
- 💻 Je développe principalement avec **Python**
- 🔧 J'apprends également **C** et **Java**
- 🔐 Je m'intéresse à la **cybersécurité et à l'ethical hacking**
- 🐧 J'expérimente avec **Linux, Termux et NetHunter**
- 🧮 J'aime appliquer la programmation aux **problèmes mathématiques**
- 🌐 Je développe également des projets web
- 📚 J'apprends en privilégiant la compréhension et la pratique

---

## 🛠️ Technologies & outils

### 💻 Programmation

![Python](https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white)
![C](https://img.shields.io/badge/C-A8B9CC?style=for-the-badge&logo=c&logoColor=black)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

### 🌐 Développement web

![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)
![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)

### 🗄️ Données & backend

![Supabase](https://img.shields.io/badge/Supabase-3ECF8E?style=for-the-badge&logo=supabase&logoColor=black)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

### 🐧 Linux & cybersécurité

![Linux](https://img.shields.io/badge/Linux-FCC624?style=for-the-badge&logo=linux&logoColor=black)
![Termux](https://img.shields.io/badge/Termux-000000?style=for-the-badge&logo=gnu-bash&logoColor=white)

Je travaille notamment avec :

- 🐧 Linux
- 📱 Termux
- 🛡️ NetHunter
- 🌐 Réseaux informatiques
- 🔎 Nmap
- 🧪 Environnements de laboratoire
- 🔐 Techniques d'ethical hacking

> ⚠️ Mes expérimentations en cybersécurité sont réalisées dans un cadre légal et éducatif.

---

# 🚀 Projets

## 🌐 ETUDAMADA

**ETUDAMADA** est un projet de plateforme éducative destinée principalement aux étudiants et élèves à Madagascar.

L'objectif est de centraliser différents contenus et services éducatifs :

- 📚 Cours
- 📝 Exercices
- ✅ Corrigés
- 🎓 Informations universitaires
- 🏫 Universités
- 🎓 Bourses
- 👨‍🏫 Enseignants et tuteurs
- 📖 Ressources pédagogiques
- 🧠 Outils d'apprentissage

Le projet évolue progressivement vers une plateforme éducative plus complète.

---

## 🧮 Résolution d'équations diophantiennes

Je développe également des programmes permettant d'étudier et résoudre des problèmes mathématiques avec Python.

Exemples de notions utilisées :

- Algorithme d'Euclide
- PGCD
- Algorithme d'Euclide étendu
- Identité de Bézout
- Équations diophantiennes
- Recherche de solutions entières
- Paramétrisation des solutions

### Exemple

```python
def euclide_etendu(a, b):
    if b == 0:
        return a, 1, 0

    g, x1, y1 = euclide_etendu(b, a % b)

    x = y1
    y = x1 - (a // b) * y1

    return g, x, y
