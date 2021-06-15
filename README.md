##Project Requirement
This project will do several things, such as:
- **User can purchase the items**
    ###Request
    **URI: /api/v1/checkout**\
    **Method: POST**\
    **Description**: It will validate whether the promo exist or not, if not exist then it will throw the error, after the transaction is inserted it will update the items value\
    **Request Body**
  ````
  {
      "products": [
          {
              "id": 1,
              "quantity": 2
          },
          {
              "id": 3,
              "quantity": 1
          }
      ],
      "promo_code": "PROMO123",
      "paid_amount": 300000
  }
  ````
  ###Response
  ````
  {
    "code": 200,
    "message": "success",
    "payment": {
        "id": 1,
        "created_at": "2021-05-21T00:00:00",
        "paid_amount": 30000,
        "discount_amount": 10000,
        "total": 20000,
        "products": [
            {
                "id": 1,
                "name": "123"
            },
            {
                "id": 2,
                "name": "1234"
            }
        ]
    }
  }
  ````
- **User can search for items**
  ###Request
  **URI: /api/v1/search**\
  **Method: GET**\
  **Description**: It will from the items that contains the keyword \
  **Query String**
  ````
  {
      "query": "keyword"
  }
  ````
  ###Response
  ````
  {
    "code": 200,
    "message": "success",
    "products": [
        {
            "id": 1,
            "name": "123",
            "price": 2000
        },
        {
            "id": 2,
            "name": "1234",
            "price": 40000
        }
    ]
  }
  ````
- **User can review for products**
  ###Request
  **URI: /api/v1/products/{id}/review**\
  **Method: POST**\
  **Description**: It will add review to product \
  **Request Body**
  ````
  {
      "product_id": 1,
      "name": "adasd",
      "rating": 3.0,
      "review": "asdasdsa"
  }
  ````
  ###Response
  ````
  {
    "code": 200,
    "message": "success"
  }
  ````
- **User can view review of products**
  ###Request
  **URI: /api/v1/products/{id}/reviews**\
  **Method: GET**\
  **Description**: It will get a reviews from product\
  **Query String**
  ````
  {
      "sort": "desc"
  }
  ````
  ###Response
  ````
  {
    "code": 200,
    "message": "success",
    "product_id": 123
    "reviews": [
        {
            "name": "asdas",
            "rating": 3.0,
            "review": "asdasdsa"
        }
    ]
  }
  ````