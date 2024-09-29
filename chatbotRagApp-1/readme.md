# Projet ChatBot RAG - Activité Pratique Finale

## Objectif
Développer une application web fullstack en utilisant **Spring Boot** pour le backend et **React avec Vaadin** pour le frontend. L'application met en œuvre un **Chatbot** basé sur un système de **Retrieval Augmented Generation (RAG)** avec les **Large Language Models (LLMs)** tels que **Llama 3** et **OpenAI**. Le chatbot permet de dialoguer avec ces modèles tout en intégrant un **Vector Store** pour vectoriser et interroger des documents.

## Fonctionnalités

### 1. Chatbot avec LLMs (Llama 3 et OpenAI)
- Permet à l'utilisateur de discuter avec un **Large Language Model (LLM)**, soit **OpenAI** ou **Llama 3**.
- Génération de réponses contextuelles basées sur les capacités avancées des **LLMs**.

### 2. Vectorisation de documents PDF
- Mise en place d'un **Vector Store** permettant de vectoriser des documents PDF.
- Utilisation d'un modèle d'**Embedding** (**OpenAI** ou **Llama**) pour créer des représentations vectorielles des documents.

### 3. Système Retrieval Augmented Generation (RAG)
- Le chatbot utilise un système **RAG** pour récupérer des informations pertinentes à partir des documents vectorisés et générer des réponses enrichies.

### 4. Migration vers PD Vector Store
- Migration du **Simple Vector Store** vers un système **PD Vector Store** pour une gestion plus efficace des données vectorielles.

### 5. Ajout de fonctionnalités supplémentaires
- Ajout d'une classe Personne avec son repository et son service pour pouvoir la récupérrer coté frontend.

