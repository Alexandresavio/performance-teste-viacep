#!groovy

import jenkins.model.Jenkins
import hudson.security.HudsonPrivateSecurityRealm
import hudson.security.FullControlOnceLoggedInAuthorizationStrategy
import jenkins.install.InstallState

def instance = Jenkins.getInstance()

// Configuração do usuário admin
def adminUsername = "admin"
def adminPassword = "admin" // ALTERE para a senha desejada

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount(adminUsername, adminPassword)
instance.setSecurityRealm(hudsonRealm)

// Define a estratégia de autorização para que apenas usuários autenticados tenham acesso total
def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false)
instance.setAuthorizationStrategy(strategy)

// Bypass do assistente de instalação inicial
instance.setInstallState(InstallState.INITIAL_SETUP_COMPLETED)
instance.save()