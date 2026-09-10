# Module 3 Assignment - Task Management API

## About the assignment

Click [here](./Module3_Assignment_mandatory.md) for the assignment details & requirements.

## API documentation

|**Method**|**Path**|**What it does**|
|---|---|---|
|GET|`/api/tasks`|Get all tasks|
|GET|`/api/tasks/{id}`|Get one task by id|
|GET|`/api/tasks/summarize`|Summarize all tasks|
|POST|`/api/tasks`|Create a new task|
|PUT|`/api/tasks/{id}`|Update an existng task|
|DELETE|`/api/tasks/{id}`|Delete a task|
|PUT|`/api/tasks/{id}/`<br>`complete`|Mark a task as complete|

Click [here](./SCTP%20AIE%20M3%20-%20Assignment.postman_collection.json) for the Postman collection of the API endpoints. 

You can download the collection and import it into Postman for testing.

<br>

![Postman import button](./src/main/resources/static/images/postman-import.png)

<br>

<img src="./src/main/resources/static/images/postman-import-select-file.png" style="width: 50%; height: auto;" alt="Postman import select file">

## Testing APIs

The endpoints have been deployed **live** on [Render](https://render.com/) free tier. 

You can test the APIs from the base url https://sctp-aie-m3-assignment.onrender.com/api/tasks.  

> Postman Collection Variable
The base url is defined in the collection variable `{{url}}` in the postman collection. If you were to deploy the APIs into another local/cloud environment/platform, you will need to update the value of the `{{url}}` variable  

> Free Tier Inactivity Note
Note that Render spins down free-tier web services after 15 minutes of inactivity. A new incoming request will experience a "cold start" delay of about 30–50 seconds while the instance wakes back up.

