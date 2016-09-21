# AppDirectImplementation
Dummy project for consuming appdirect subscription events

You can checkout all the apis by using swagger home: 

http://localhost:8080/AppDirect/swagger/index.html

To run the project, you will need gradle on your system. Run 'gradle bootRun' on the project's root(where build.gradle file is located)

If the AppDirectImplementation project is hosted on a local system, you can use ngrok to make it accessible from public domain.

ngrok setup can be found here : https://ngrok.com/ 
Browse to the ngrok home and run on command prompt the following : ngrok.exe http 8080
After this you will be able to find the public url for your localhost which should be something like :

 https://2fb6a249.ngrok.io/ (replacement for localhost)
 
 So you will need to update the subscription endpoint urls in the AppDirect application configuration to the above URLs.

For create subscription:

https://2fb6a249.ngrok.io/AppDirect/subscribe/create?url={eventUrl}

For cancel subscription:

https://2fb6a249.ngrok.io/AppDirect/subscribe/cancel?url={eventUrl}


All the resource CRUD operation apis are under the resource tab in the swagger index page.

ADD operation: https://2fb6a249.ngrok.io/AppDirect/resource/add POST Request and the request json format is like below:
{
  "content": [
    {
      "id": "string",
      "value": "string"
    }
  ]
}

(list of id value objects)

UPDATE Operation: https://2fb6a249.ngrok.io/AppDirect/resource/update POST request and the request json format:
{
  "content": [
    {
      "id": "string",
      "value": "string"
    }
  ]
}

DELETE operation: http://2fb6a249.ngrok.io/AppDirect/resource/{ids} DELETE request. Replace ids with comma separated URLencoded ids.
GET operation: http://2fb6a249.ngrok.io/AppDirect/resource/{ids} GET request. Replace ids with comma separted URLencoded ids.


Currently the GET on the resource is done on one of the database that is hashmapdb.(Configurable from the application.properties file). The DELETE UPDATE and ADD operation are performed on all the databases available.


For using the subscription and resource apis you will need to login first using login apis. Username and password are admin/123123 (hardcoded for now)


