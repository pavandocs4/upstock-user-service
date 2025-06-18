User-service

1. add new user
   curl --location 'http://localhost:8082/user/create' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "abc123",
	"password": "Rahul",
    "emailId" : "abc@gmail.com"
}'
