
# http-images-spring-boot

The goal here is return image diferente for eatch HTTP Status Code informed by User 

# Technoliges
<ul>
  <li>Java11</li>
  <li>Gradle</li>
  <li>SpringBoot</li>
</ul>
  
# Run local
`./gradlew bootRun`

`curl http://localhost:8080/images/100`

# Run with Docker

`./gradlew clean build`

`sh build.sh`

`sh run.sh`

# References
 https://text2image.com/en/
 https://http.cat/
 https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
  