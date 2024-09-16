import shared.*

def maven = new Maven()

node {
    stage('Checkout') {
        checkout scm
    }

    stage('Build Modules') {
        def pomXml = maven.readPomXml() // Читання головного pom.xml
        def modules = pomXml.modules.module.collect { it.text() } // Отримання списку модулів

        modules.each { module ->
            def modulePomPath = "${module}/pom.xml"
            if (fileExists(modulePomPath)) {
                def modulePom = maven.readPomXml(modulePomPath)
                if (maven.isJarPackaging(modulePom)) {
                    echo "Building module: ${module}"
                    dir(module) {
                        maven.startBuild() // Запуск білду для модуля
                    }
                } else {
                    echo "Skipping module: ${module}, as it is not a JAR packaging."
                }
            } else {
                echo "No pom.xml found for module: ${module}"
            }
        }
    }
}
