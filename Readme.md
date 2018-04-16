# PLD SMART

## MYSQL
### Démarrer MYSQL Server
Une fois MySQL server installé, il faut le démarer avec la commande
```jshelllanguage
$ mysql -h localhost -u root -p
```
Ensuite il faut renseigner son mot de passe et appuyer sur **Entrer**

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
- Voir toutes les tables présentes : 
```jshelllanguage
mysql> show tables;
```
## TODO
- [ ] Refaire modèle de données
- [ ] Associations unidirectionnelles ou bidirectionnelles ?
- [ ] Pour les associations vérifier les Updates en CASCADE et les objets orphelins
- [ ] Mettre en place les DAO 

