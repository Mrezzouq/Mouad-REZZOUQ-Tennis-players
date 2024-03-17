# Tennis players - Atelier kata

Ce projet a été développé en suivant le Domain-Driven Design (DDD) accompagné d'une architecture hexagonale. Cette
approche nous permet de mieux isoler le domaine de l'application. Facilitant ainsi son évolutivité et sa maintenance.
Dans le Swagger, vous trouverez une documentation exhaustive détaillant chaque API, incluant des informations sur son
fonctionnement, les paramètres attendus, les types de réponses et des exemples d'utilisation. Cette documentation vise à
offrir une compréhension claire et précise des points d'intégration disponibles pour les développeurs, facilitant ainsi
l'intégration et l'expérimentation avec l'application

## Prérequis

- Java JDK 17
- Gradle

## Démarrage en Local

Pour démarrer l'application localement sans Docker, suivez les étapes ci-dessous :

```bash
git clone https://github.com/Mrezzouq/Mouad-REZZOUQ---Atelier.git
```

L'application devrait maintenant être accessible sur http://localhost:8080/swagger-ui/index.html

## Démarrage avec docker

L'image Docker de l'application est disponible sur mon Docker Hub. Pour la récupérer, veuillez exécuter la commande
suivante dans votre terminal. Cela permettra de télécharger l'image nécessaire pour exécuter l'application
``docker pull rq8mouad/tennis_players:latest``

Après avoir récupéré l'image, vous pouvez démarrer l'application de deux manières. La première méthode consiste à
utiliser docker-compose up. Cette commande recherche le fichier docker-compose.yml dans le répertoire courant et lance
tous les services définis.

La seconde méthode est d'utiliser la commande docker run -p 8080:8080 tennis_players. Cette commande démarre un
conteneur basé sur l'image tennis_players, en mappant le port 8080 du conteneur sur le port 8080 de l'hôte. Cela
signifie que l'application sera accessible à l'adresse http://localhost:8080/swagger-ui/index.html.

Peu importe la méthode choisie, l'application devrait être accessible sur le même port qu'auparavant, vous permettant
d'interagir avec elle via votre navigateur ou tout autre client HTTP

## Déploiement sur AWS ECS

L'application est déployée sur un cluster ECS qui exécute la tâche dans un environnement de conteneurs géré, permettant
une mise à l'échelle automatique, une gestion des ressources efficace et une haute disponibilité

l'application est accessible via les API suivantes :

- pour récupérer la liste des joueurs triées :
  ``http://13.38.48.45:8080/v1/tennis-player``
- pour récupérer un joueur par son identifiant :
  ``http://13.38.48.45:8080/v1/tennis-player/{playerId}``
- pour les statistiques des joueurs :
  ``http://13.38.48.45:8080/v1/tennis-player/statistics``