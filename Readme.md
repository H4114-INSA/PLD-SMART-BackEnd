# PLD SMART - Back end
*Remarque : l'ensemble du projet a été developpé avec l'IDE IntelliJ IDEA de Jet Brains dont il existe une version communautaire gratuite. Nous expliquerons dans ce qui suit comment lancer les différentes parties grâce à cette IDE.*
##Equipement minimal
Le back-end est projet développé sur le framework *Spring Boot*. Nous utilisons le langage Java en version 8, il est donc necessaire de disposer d'un **JDK supportant Java 8**. 
Ce projet peut être compilé grâce à **Maven 3.2 ou +**. 
Nous utilisons **MySQL Server** en tant que serveur de base de données relationnelles. 
Il faut disposer d'une version récente du serveur Web **Apache Tomcat**.

##MySQL
### Démarrer MYSQL Server
Une fois MySQL server installé, il faut le démarer avec la commande
```jshelllanguage
$ mysql -h localhost -u root -p
```
Ensuite il faut renseigner son mot de passe et appuyer sur **Entrer**

#### En cas d'erreur au démarrage `ERROR 2003 (HY000): Can't connect to MySQL server on 'localhost'`
1. Aller dans **Services** sur Windows. 
2. Chercher le service **MYSQL**, puis *clique droit* et appuyer sur **Start** 
3. Relancer la commande précédente

### Créer une base de données sur MYSQL et l'utiliser sur le projet
Cette étape est entièrement détaillée sur le tutoriel de Spring : *Accessing data with MySQL* ([Tuto MySQL Spring.io](https://spring.io/guides/gs/accessing-data-mysql/))

### Voir le contenu d'une base de données
- Ce mettre dans la base souhaitée : 
```jshelllanguage
mysql> use db_example;
```
- Voir toutes les tables présentes : 
```jshelllanguage
mysql> show tables;
```
- Voir toutes les colonnes d'une table : 
```jshelllanguage
mysql> show columns from table_name;
```
- Remplir la base de données
```jshelllanguage
mysql> source pathToFile_unix_style;
```
##Compiler et lancer l'application depuis IntelliJ IDEA
Une fois l'ensemble des paramètres relatifs à la base de données renseigner, 
il suffit de définir le point d'entrée de l'application en faisant un *Clic droit* sur 
*SMARTBackEndApplication.java* et appuyer sur **Run**. Vou devriez voir apparaitre en console 
le déroulement du déploiement.

Une fois déployer il est possible de peupler la base de donnée avec le script *DataForDB.sql* disponible
dans le répétoire *Ressources*.






