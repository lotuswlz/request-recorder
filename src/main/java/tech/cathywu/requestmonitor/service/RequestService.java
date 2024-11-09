package tech.cathywu.requestmonitor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import tech.cathywu.requestmonitor.model.RequestDto;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveRequest(RequestDto request) {
        mongoTemplate.save(request);
    }

    public List<RequestDto> getRecordsByMethod(String method) {
        return mongoTemplate.find(Query.query(Criteria.where("method").is(Optional.ofNullable(method).map(String::toUpperCase).orElse(null))), RequestDto.class);
    }

    public List<RequestDto> getAllRecords() {
        return mongoTemplate.findAll(RequestDto.class);
    }
}
