# TARA-integration module installation and configuration guide.

# 0. Used variables description

* `${PROJECT_ROOT}` - root folder of the project

# 1. Dependencies

## 1.1 Postgres database

In order to run TIM you need Postgres database.

You can set one up using Docker from out [Third-party-components](https://github.com/buerokratt/Third-party-components) repository.

## 1.2 ID-log

In order to change the source code and compile outside Docker you'll need [ID-log](https://github.com/buerokratt/Java.commons/tree/public).

*Note!* You will not need it to run Docker.

# 2. Configuration

Spring Boot applications support externalized configuration through *.properties files.

Application configuration can be found here: `${PROJECT_ROOT}/src/main/resources/application.properties`.

## 2.1 Certificates generation

**Note!** Both keystore password and alias password should be the same.

### 2.1.1 Tomcat SSL support

Tomcat SSL certificate is generated in Docker with:

```
keytool -genkeypair -alias tomcat -keyalg RSA -keysize 2048 -keystore "keystore.jks" -validity 3650
```

* The generated keystore should be configured in the `application.properties`

### 2.1.2 Certificate for JWT signature

JWT certificate is generated in Docker with:

```
keytool -genkeypair -alias jwtsign -keyalg RSA -keysize 2048 -keystore "jwtkeystore.jks" -validity 3650
```

relevant configuration properties:

```
jwt-integration.signature.key-store=classpath:jwtkeystore.jks
jwt-integration.signature.key-store-password=ppjjpp
jwt-integration.signature.keyStoreType=JKS
jwt-integration.signature.keyAlias=jwtsign
```

### 2.1.3 Changing Keystore password

To change keystore password, update Dockerfile and configuration with new password.

# 3. Running in Docker

Run docker with `docker-compose up -d`

**Note!** Some configuration changes may require you to rebuild docker image using `docker-compose build` for them to take effect.

## Licence

See licence [here](LICENSE).
