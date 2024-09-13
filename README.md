# Documentation du Projet

## Installation

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
    - `GET /api/forums/{id}` : Récupérer un forum
    - `POST /api/subject/{id}` : Créer un sujet dans un forum
    - `GET /api/subject/{id}` : Récupérer la liste des sujets d'un forum
    - `GET /api/subject/{id}` : Récupérer un sujet
    - `POST /api/messages/{id}` : Créer un message dans un sujet
    - `GET /api/messages/{id}` : Récupérer la liste des messages d'un sujet
    - `GET /api/messages/{id}` : Récupérer la liste des messages d'un sujet