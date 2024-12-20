### **Utilisation du JAR**
Avant de créer le fichier **JAR**, vous devez compiler les fichiers sources Java.

- Ouvrez un terminal et naviguez jusqu'au répertoire où se trouvent vos fichiers source (`src`).
- Ensuite, exécutez la commande suivante pour compiler les fichiers Java dans le dossier de destination `bin` :

```bash
javac -d bin -sourcepath src main/java/bibliotheque/*.java
