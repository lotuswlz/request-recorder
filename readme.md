# Request Recorder
## Get Started
### Install Mongo DB and Run it
Bellowing steps are only for local testing:
1. Create a folder for data files of mongo db:
```bash
$ mkdir mongo-data
```

2. Start mongod, by default the host is 127.0.0.1, the port is 27017.
```bash
$ mongod --dbpath=./mongo-data
```

3. Initialize database (if needed)
```bash
$ mongo
> use request_monitor
> db.request_record.save({...YOUR_DATA...}) 
> exit
```

### Startup the application
1. Build the jar file: ```mvn clean package```
2. Set environment for mongo host and port:
```bash
$ export MONGO_HOST=127.0.0.1
$ export MONGO_PORT=27017
```
3. Startup your application:
```bash
$ java -jar ./target/request-monitor-server-1.0.jar
```
