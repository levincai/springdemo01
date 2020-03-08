node {
  jdk = tool name: 'jdk8'
  env.JAVA_HOME = "${jdk}"
  sh "${jdk}/bin/java -version"
   // Mark the code checkout 'stage'....
   stage 'Checkout'
   
   git url: 'https://github.com/levincai/springdemo01.git'

   // Mark the code build 'stage'....
   stage 'Build'
   
   def mvnHome = tool 'Maven3.6.1'
   // Run the maven build
   bat "${mvnHome}/bin/mvn -B -DskipTests clean package"
   step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
}