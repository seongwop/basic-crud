# basic-crud

- Use Case

![Use Case.png](Use%20Case.png)

- API Statement

| Method | URL           | Request                                                                                                          | Response                                                                                                                                                                                                                                                                                                                                                                                                                               |   
|--------|---------------|------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| GET    | /api/posts    | -                                                                                                                | {<br/>{<br/>"id" : "1",<br/>"title" : "title1",<br/> "author" : "author1",<br/> "content" : "content1",<br/> "createdAt" : "2023-04-18T00:20:15.281109",<br/>"modifiedAt" : "2023-04-18T00:21:26.485111"}<br/>},<br/>{<br/>"id" : "2",<br/>"title" : "title2",<br/> "author" : "author2",<br/> "content" : "content2",<br/> "createdAt" : "2023-04-18T00:20:15.281109",<br/>"modifiedAt" : "2023-04-18T00:21:26.485111"}<br/>...<br/>} |   
| GET    | /api/post{id} | -                                                                                                                | {<br/>"id" : "1",<br/>"title" : "title1",<br/> "author" : "author1",<br/> "content" : "content1",<br/> "createdAt" : "2023-04-18T00:20:15.281109",<br/>"modifiedAt" : "2023-04-18T00:21:26.485111"}<br/>}                                                                                                                                                                                                                              |   
| POST   | /api/post     | {<br/>"title" : "title",<br/> "author" : "author",<br/> "password" : "password",<br/> "content", "content"<br/>} | {<br/>"id" : "1",<br/>"title" : "title1",<br/> "author" : "author1",<br/> "content" : "content1",<br/> "createdAt" : "2023-04-18T00:20:15.281109",<br/>"modifiedAt" : "2023-04-18T00:21:26.485111"}<br/>}                                                                                                                                                                                                                              |   
| PUT    | /api/post{id} | {<br/>"title" : "title",<br/> "author" : "author",<br/> "password" : "password",<br/> "content", "content"<br/>} | {<br/>"id" : "1",<br/>"title" : "title1",<br/> "author" : "author1",<br/> "content" : "content1",<br/> "createdAt" : "2023-04-18T00:20:15.281109",<br/>"modifiedAt" : "2023-04-18T00:21:26.485111"}<br/>}                                                                                                                                                                                                                              |  
| DELETE | /api/post{id} | {<br/>"password" : "password"<br/>}                                                                              | 200                                                                                                                                                                                                                                                                                                                                                                                                                                    |  

- ? Why
1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)
    - 수정, 삭제 모두 id는 PathVariable로 전달하고 데이터는 RequestBody를 통해 객체에 담아서 전달
2. 어떤 상황에 어떤 방식의 request를 써야하나요?
    - 게시글 전부를 조회하는 GET 방식에서는 request할 필요가 없고, 특정 게시글을 조회하는 GET 방식에서는 id 값만 PathVariable로 전달, 나머지 POST, PUT, DELETE 방식에서는 전부 PathVariable을 통한 id값과 RequestBody를 통한 데이터를 담은 객체를 전달
3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?
    - HTTP URI(Uniform Resource Identifier)를 통해 자원(Resource)을 명시하고, HTTP Method(POST, GET, PUT, DELETE)를 통해 해당 자원에 대한 CRUD Operation을 적용함으로써 RESTful API 설계
4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)
    - 전부 분리하여 적용
5. API 명세서 작성 가이드라인을 검색하여 직접 작성한 API 명세서와 비교해보세요!
