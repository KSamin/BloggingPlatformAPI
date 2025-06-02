# Blogging Platform REST API

This is a CRUD-based Blogging Platform REST API built using Spring Boot and MongoDB,
designed to help learn REST principles, HTTP methods, status codes, and database operations.

project URL : https://roadmap.sh/projects/blogging-platform-api

## Features
* Create a new blog post

* Get a single blog post by ID

* Get all blog posts

* Update an existing blog post

* Delete a blog post

* Search blog posts by title, content, or tags

## Technologies Used

| Tech        | Description          |
|-------------|----------------------|
| Java        | Programming language |
| Spring Boot | Backend framework    |
| MongoDB     | NoSQL database       |
| Maven       | Dependency management|
| Postman     | API testing tool     |

## Project Structure

````
src/
├── controller/
│   └── PostController.java
├── dto/
│   └── PostDto.java
├── exception/
│   ├── ResourceNotFoundException.java
│   └── GlobalExceptionHandler.java
├── model/
│   └── Post.java
├── repository/
│   └── PostRepository.java
├── service/
│   └── PostService.java
````
## API EndPoints

| Method | Endpoint                      | Description                  | Request Body Required |
| ------ | ----------------------------- | ---------------------------- | --------------------- |
| POST   | `/api/posts`                  | Create a new blog post       | ✅ Yes                 |
| GET    | `/api/posts`                  | Get all blog posts           | ❌ No                  |
| GET    | `/api/posts/{id}`             | Get a blog post by ID        | ❌ No                  |
| PUT    | `/api/posts/{id}`             | Update a blog post by ID     | ✅ Yes                 |
| DELETE | `/api/posts/{id}`             | Delete a blog post by ID     | ❌ No                  |
| GET    | `/api/posts/search?query=xyz` | Search blog posts by keyword | ❌ No                  |

## HTTP Status Code
| Code | Meaning               | Used When?                             |
| ---- | --------------------- | -------------------------------------- |
| 200  | OK                    | GET, PUT, DELETE successful            |
| 201  | Created               | POST successful                        |
| 204  | No Content            | GET returns empty list                 |
| 400  | Bad Request           | Validation errors in POST/PUT          |
| 404  | Not Found             | Post not found for given ID            |
| 500  | Internal Server Error | Server error while processing requests |


## Sample postman request
### Create Blog Post
* Method: POST

* URL: http://localhost:8082/api/posts

* Headers: Content-Type: application/json

* Body:
```bash
{
  "title": "My New Blog",
  "content": "Blog content here.",
  "category": "Tech",
  "tags": ["Spring", "MongoDB"]
}

```
### GET All Posts(GET)
``http://localhost:8082/api/posts``

### Get Single Post (GET)
`` http://localhost:8082/api/posts/{id}``

### Update Blog Post (PUT)
`` URL: http://localhost:8082/api/posts/{id}``

* Method: PUT

* Headers: Content-Type: application/json

* Body:

``` bash 
{
"title": "Updated Title",
"content": "Updated Content",
"category": "DevOps",
"tags": ["CI", "CD"]
}
```
### Delete Blog Post (DELETE)
``http://localhost:8082/api/posts/{id}``

### Search Blog Posts (GET)
``http://localhost:8082/api/posts/search?query=java``

## To Run The Project

1. Clone the repository

2. Make sure MongoDB is running locally

3. Run the Spring Boot application

4. Use Postman to hit the endpoints
