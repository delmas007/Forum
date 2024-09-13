# Documentation du Projet

## Installation

**Prerequis**
- Java 17
- Maven
- Git
- Postman
- IDE (IntelliJ IDEA, Eclipse, NetBeans, etc.)
- Base de données PostgreSQL


Pour installer le projet, suivez les étapes suivantes :

1. **Clonez le dépôt :**
   ```bash
   git clone https://github.com/delmas007/Forum.git
    ```
   charger maven pour l'installation des dépendances.

2. **Exécutez le projet :**
   ```bash
   mvn spring-boot:run
   ```
3. **Les endpoints :**
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