# NetTest


curl http://localhost:8080/ping
	{"message":"pong","creationDate":"May 14, 2018 8:15:27 PM BRT"}ubuntu@cbafc62cb39c:/$ curl http://localhost:8080/ping -i
	HTTP/1.1 200
	Content-Type: application/json;charset=UTF-8
	Transfer-Encoding: chunked
	Date: Mon, 14 May 2018 23:15:30 GMT
	
	{"message":"pong","creationDate":"May 14, 2018 8:15:30 PM BRT"}


curl --header "Content-Type: application/json" --request POST \
  --data '{"url": "http://someurl/"}' http://localhost:8080/proxyRequest