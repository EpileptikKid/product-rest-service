## Lightweight RESTful API with Spring Boot, Docker, PostgreSQL, JPA  etc.

## How it works:
### **1. Docker. First, you need to install docker**
* Download Docker [Here](https://docs.docker.com/docker-for-windows/install/). Hint: Enable Hyper-V feature on windows and restart;
* Then open powershell and check docker version:
```bash
docker -v
```
and docker compose version
```bash
docker-compose -v
```

### **2. Spring boot app**
* Clone the repository:
```bash
git clone https://github.com/EpileptikKid/product-rest-service.git
```
* Running the containers:
  This command will build the docker containers and start them.
```bash
docker-compose up
```

Appendix A.

All commands should be run from project root (where docker-compose.yml locates)
* If you have to want to see running containers. Checklist docker containers
```bash
docker container list -a
```
or
```bash
docker-compose ps
```

![Screenshot docker containers list](/images/screen-1.png)
*Screenshot with runnings containers*

## **Guide for using endpoints the app:**
* Go to the address - "http://localhost:8081", and then -
### **Groups endpoints:**
* GET request to `/api/groups` returns a list of "groups";
* GET request to `/api/groups/1` returns the "group" with ID 1;
* POST request to `/api/groups` with a "group" object as JSON creates a new "group";
* PUT request to `/api/groups/3` with a "group" object as JSON updates the "group" with ID 3;
* DELETE request to `/api/groups/4` deletes the "group" with ID 4.
---
* GET request to `/api/groups?sortBy=name` returns a list of "groups" sorted by name;
* GET request to `/api/groups?search="veget"` returns "group"`s with "veget" in their name or description;
---
![Screenshot GET /api/gtoups](/images/screen_group.png)
*Screenshot with GET to /api/groups example*
---
### **Subgroups endpoints:**
* GET request to `/api/subgroups` returns a list of "subgroups";
* GET request to `/api/subgroups/1` returns the "subgroup" with ID 1;
* POST request to `/api/subgroups` with a "subgroup" object as JSON creates a new "subgroup";
* PUT request to `/api/subgroups/3` with a "subgroup" object as JSON updates the "subgroup" with ID 3;
* DELETE request to `/api/subgroups/4` deletes the "subgroup" with ID 4.
---
* GET request to `/api/groups?sortBy=name` returns a list of "subgroups" sorted by name;
* GET request to `/api/groups?search="potato"` returns "subgroup"`s with "potato" in their name or description;
---
![Screenshot GET /api/subgroups/2](/images/screen_subgroup.png)
*Screenshot with GET to /api/subgroups/2 example*
---
### **Products endpoints:**
* GET request to `/api/products` returns a list of "products";
* GET request to `/api/products/1` returns the "product" with ID 1;
* POST request to `/api/products` with a "product" object as JSON creates a new "product";
* PUT request to `/api/products/3` with a "product" object as JSON updates the "product" with ID 3;
* DELETE request to `/api/products/4` deletes the "product" with ID 4.
---
![Screenshot POST /api/products](/images/screen_product.png)
*Screenshot with POST to /api/products example*
---
* GET request to `/api/products?sortBy=price` returns a list of "products" sorted by price;
* GET request to `/api/products?search="potato"` returns "product"`s with "potato" in their name;