# Bibliothèque de géométrie

## Description

Ce projet est une bibliothèque Java qui permet de manipuler et d'effectuer des calculs géométriques sur différentes formes géométriques telles que des points, des lignes, des cercles, des carrés, des rectangles et des polygones. Il comprend des fonctionnalités pour calculer des distances entre différentes entités géométriques et tester des relations géométriques telles que l'inclusion de points dans des polygones.

## Fonctionnalités principales

- **Calcul des distances** : Calcul de la distance entre des points, entre un point et une ligne, entre un point et un cercle, entre des polygones, etc.
- **Tests géométriques** : Vérification si un point est à l'intérieur d'un polygone, distance entre un carré et un cercle, etc.
- **Manipulation de formes géométriques** : Création et manipulation de points, lignes, cercles, carrés, rectangles et polygones.

## Structure du projet

Le projet comprend plusieurs classes Java qui sont organisées de la manière suivante :

### 1. **Point**
   - Représente un point dans un plan 2D.
   - Attributs : `x`, `y` (coordonnées du point).
   - Méthodes : `getX()`, `getY()`, `setX()`, `setY()`, etc.

### 2. **Line**
   - Représente une ligne dans le plan 2D sous forme d'équation linéaire `y = mx + b`.
   - Attributs : `m` (pente), `b` (ordonnée à l'origine).
   - Méthodes : `getEquation()`, `distanceFromPoint()`, etc.

### 3. **Circle**
   - Représente un cercle dans le plan 2D.
   - Attributs : `radius` (rayon), `center` (centre du cercle, instance de `Point`).
   - Méthodes : `getRadius()`, `getCenter()`, `distanceFromPoint()`, etc.

### 4. **Rectangle**
   - Représente un rectangle défini par ses quatre coins (instances de `Point`).
   - Attributs : `upper_left`, `upper_right`, `bottom_left`, `bottom_right` (points définissant les coins du rectangle).
   - Méthodes : `setData()`, `setX()`, `setY()`, etc.

### 5. **Square**
   - Hérite de `Rectangle` et représente un carré.
   - Attributs : `length` (longueur d'un côté du carré).
   - Méthodes : `getPoints()` pour obtenir les quatre coins du carré.

### 6. **Polygon**
   - Représente un polygone défini par une liste de points.
   - Attributs : `points` (une liste de `Point`).
   - Méthodes : `addPoint()`, `isPointInside()`, etc.

### 7. **Calcul**
   - Contient des méthodes utilitaires pour effectuer des calculs géométriques (distances, tests d'inclusion, etc.).
   - Méthodes : `distanceFromPointToPoint()`, `distanceFromPointToLine()`, `calculateMinDistance()`, etc.

### 8. **Main**
   - Contient la méthode `main` avec des tests pour vérifier le bon fonctionnement des différentes classes et méthodes du projet.
   - Exécute des exemples de calculs de distance entre points, lignes, cercles, polygones, etc.

## Installation

1. **Cloner le projet** :
   Pour récupérer le projet sur votre machine locale, utilisez la commande suivante dans votre terminal :
   ```bash
   git clone https://github.com/ton-utilisateur/bibliotheque-geometry.git


2. **Utilisation du JAR**:
Avant de créer le fichier **JAR**, vous devez compiler les fichiers sources Java.

- Ouvrez un terminal et naviguez jusqu'au répertoire où se trouvent vos fichiers source (`src`).
- Ensuite, exécutez la commande suivante pour compiler les fichiers Java dans le dossier de destination `bin` :

```bash
javac -d bin -sourcepath src main/java/bibliotheque/*.java
jar cf lib/bibliotheque.jar -C bin 

