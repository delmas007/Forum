# Documentation du Projet



### **Description du projet**

         Ce projet a pour objectif de développer une API REST pour la gestion d'un forum en ligne.
      L'API permet de gérer plusieurs entités : forums, sujets au sein des forums, et messages associés à chaque sujet.
      Conçu avec le framework Spring Boot, ce projet respecte les principes RESTful et est construit en Java 17.
      L'objectif principal est de renforcer la maîtrise des concepts d'API REST, tout en exploitant les fonctionnalités avancées de Spring Boot pour créer une application web robuste.


### **Objectifs**

      Apprendre à utiliser Spring Boot pour développer une API REST.
      Implémenter une architecture RESTful.
      Gérer des entités complexes telles que les forums, les sujets et les messages.
      Se familiariser avec la persistance des données à l'aide de Spring Data JPA et de PostgreSQL.
      Fonctionnalités

#### **Forum**

      Créer un forum : Permet la création d'un nouveau forum dans l'application.
      Lister tous les forums : Récupérer la liste des forums disponibles.
      Détails d'un forum : Récupérer les informations spécifiques d'un forum en utilisant son ID.

#### **Subject**

      Créer un sujet : Créer un nouveau sujet dans un forum.
      Lister tous les sujets : Récupérer la liste des sujets dans un forum spécifique.
      Détails d'un sujet : Récupérer les informations d'un sujet en particulier.

#### **Message**

      Créer un message : Ajouter un nouveau message dans un sujet existant.
      Lister tous les messages : Récupérer la liste des messages associés à un sujet spécifique.

#### **Exigences techniques**

      Java 17 pour tirer parti des nouvelles fonctionnalités du langage.
      Spring Boot 3.x pour la configuration rapide du projet et la gestion des dépendances.
      Spring Data JPA pour la persistance des données.
      PostgreSQL comme base de données relationnelle.
      Postman pour documenter et tester l'API.

#### **Prérequis**

Pour installer le projet, suivez les étapes suivantes :

1. **Clonez le dépôt :**
   ```bash
   git clone https://github.com/delmas007/Forum.git
    ```
   charger maven pour l'installation des dépendances.

2. **Exécutez le projet :**
   ```bash
   mvn spring-boot:run

#### **Structure du projet**
 
Le projet suit une architecture propre avec une séparation des responsabilités.

         web : Contient les classes qui gèrent les requêtes HTTP.
         services : Gère la logique métier.
         repositories : Interface avec la base de données.
         models : Représente les entités (Forum, Subject, Message).
         dto : Objet de transfert de données (Data Transfer Object).

**Les endpoints :**

Si vous avez besoin de tester les endpoints, vous pouvez utiliser Postman ou tout autre outil de test d'API. Voici les endpoints disponibles :

    - `GET /api/forums` : Récupérer la liste des forums
    - `POST /api/forums` : Créer un forum
    - `GET /api/forums/{id}` : Récupérer un forum par son id
    - `GET /api/forums/slug/{slug}` : Récupérer un forum par son slug
    - `POST /api/subject/{id}` : Créer un sujet dans un forum par son id
    - `POST /api/subject/slug/{slug}` : Créer un sujet dans un forum par son slug
    - `GET /api/subject/{id}` : Récupérer la liste des sujets d'un forum par son id
    - `GET /api/subject/slug/{slug}` : Récupérer la liste des sujets d'un forum par son slug
    - `GET /api/subject/{id}` : Récupérer un sujet par son id
    - `GET /api/subject/slug/{slug}` : Récupérer un sujet par son slug
    - `POST /api/messages/{id}` : Créer un message dans un sujet par son id
    - `POST /api/messages/slug/{slug}` : Créer un message dans un sujet par son slug
    - `GET /api/messages/{id}` : Récupérer la liste des messages d'un sujet par son id
    - `GET /api/messages/slug/{slug}` : Récupérer la liste des messages d'un sujet par son slug