# openlgu
OpenLGU is a modular, reactive government service platform designed to digitize and streamline core Local Government Unit (LGU) operations.

# Contributing to OPENLGU (Setup Guide)

This guide explains how to set up the project locally and connect it to the GitHub repository for development and contributions.

---

# 1. Prerequisites

Before starting, ensure you have:

* Git installed → https://git-scm.com
* Java JDK installed (openjdk version "26" 2026-03-17)
* Spring Tool Suite (STS)

---

# 2. Clone the Repository (Recommended for new contributors)

Open a terminal and run:

```bash
git clone https://github.com/lrlorenzo/openlgu.git
cd openlgu
```

This will create a local copy of the project.

---

# 3. If You Already Have Local Code (Manual Linking)

If you already have an existing project folder, you can connect it to GitHub manually:

## Step 1: Go to your project directory

```bash
cd C:\workspaces\openlgu
```

---

## Step 2: Initialize Git (if not yet initialized)

```bash
git init
```

---

## Step 3: Set the main branch

```bash
git branch -M main
```

---

## Step 4: Connect to GitHub repository

```bash
git remote add origin https://github.com/lrlorenzo/openlgu.git
```

Verify remote:

```bash
git remote -v
```

---

## Step 5: Pull existing repository content (if any)

If the GitHub repository already contains files:

```bash
git pull origin main --allow-unrelated-histories
```

---

## Step 6: Add and commit your local code

```bash
git add .
git commit -m "Initial commit"
```

---

## Step 7: Push to GitHub

```bash
git push -u origin main
```

---

# 4. Authentication (GitHub PAT)

GitHub no longer supports password authentication for Git operations.

When prompted:

* **Username:** your GitHub username
* **Password:** your Personal Access Token (PAT)

To create a PAT:

1. Go to GitHub Settings
2. Developer Settings → Personal Access Tokens
3. Generate a new token (classic or fine-grained)
4. Copy and store it securely

> Important: The token is shown only once.

---

# 5. Using Spring Tool Suite (STS)

If using STS:

### Recommended approach:

1. Import project as Maven project:

   * File → Import → Existing Maven Projects
2. Point to:

   ```
   C:\workspaces\openlgu
   ```

### Avoid:

* Creating nested project folders (e.g., `openlgu/openlgu`)
* Letting STS create duplicate workspace structures

---

# 6. Contribution Workflow

Typical workflow:

```bash
git checkout -b feature/your-feature-name
git add .
git commit -m "Describe your change"
git push origin feature/your-feature-name
```

Then create a Pull Request on GitHub.

---

# 7. Notes for Contributors

* Keep commits clean and focused
* Avoid committing IDE-specific metadata
* Always pull before pushing to avoid conflicts
* Follow existing project structure

---

# 8. PostgreSQL Setup (Required for Local Development)

OPENLGU uses PostgreSQL as its primary database.

## Step 1: Install PostgreSQL

Download and install PostgreSQL:

https://www.postgresql.org/download/

During installation, set:

* **Username:** `postgres`
* **Password:** `postgres` *(you may change this based on your preference)*

---

## Step 2: Create the database

Open **psql terminal** or **pgAdmin Query Tool**, then run:

```sql
CREATE DATABASE openlgu;
```

---

## Step 3: Verify database creation

```sql
\l
```

You should see `openlgu` listed.

---

## Step 4: Default connection settings

Use these values in your Spring Boot configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/openlgu
spring.datasource.username=postgres
spring.datasource.password=postgres
```

> ⚠️ Note: You may change the username and password based on your local or production security preferences.

---

## Step 5: Recommended next step

After setup, run database migrations or schema initialization (if provided in the project).

---

# 9. Running the Application

## Using Spring Tool Suite (STS)

To run the application:

1. Open STS
2. Import the project (if not yet imported):

   * File → Import → Existing Maven Projects
3. Select:

   ```
   C:\workspaces\openlgu
   ```
4. Right-click the project:

   ```
   OpenLGU → Run As → Spring Boot App
   ```

The application will start on:

```
http://localhost:8080
```

---

# 10. Testing the API (Postman)

You can test the running application using Postman or any REST client.

## Example health/test endpoint:

```
GET http://localhost:8080/openlgu/residents/ping
```

Expected response:

```
OpenLGU Reactive API is running
```

---