# PLD SMART

## MYSQL
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

## TODO
- Filtrage des poi pour la carte


