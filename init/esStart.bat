docker run -d --name=elasticsearch -p 9200:9200 -p 9300:9300 -v E:\WorkSpace\tagSystem\init\es-data\elasticsearch.yml:/usr/share/elasticsearch/config/elasticsearch.yml -v  E:\WorkSpace\tagSystem\init\es-data\data:/usr/share/elasticsearch/data elasticsearch:7.10.1
rem docker run -d -e SERVER_NAME=kinbana -e ELASTICSEARCH_HOSTS=http://elasticsearch:9200 -p 5601:5601 kibana:7.10.1
docker run -d  --name=kinbana --link elasticsearch:elasticsearch -p 5601:5601 kibana:7.10.1
rem docker run -d  --name=elasticsearch-head  --restart=always -p 9100:9100 -v E:\WorkSpace\tagSystem\init\es-data\es-header\app.js:/usr/src/app/_site/app.js mobz/elasticsearch-head:5-alpine
docker ps -a
pause