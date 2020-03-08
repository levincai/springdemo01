node {
   // Mark the code checkout 'stage'....
   stage 'Checkout'
   
   git url: 'https://github.com/levincai/springdemo01.git'

   // Mark the code build 'stage'....
   stage 'Build'
   // Run the maven build
    sh 'mvn -B -DskipTests clean package'
   step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
}