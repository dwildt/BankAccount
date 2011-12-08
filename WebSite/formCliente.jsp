<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<head>
<title>Incluir Cliente</title>
</head>
<body bgcolor="#ffffff">

<h1>Incluir Cliente - 005</h1>
<f:view>
  <h:form>
    <h:panelGrid columns="3">
      <h:outputLabel for="edCpf">
        <h:outputText value="CPF"/>
      </h:outputLabel>
      <h:inputText id="edCpf" value="#{clienteManager.cliente.cpf}" rendered="#{!clienteManager.edicao}"/>
      <h:outputText id="lblCpf" value="#{clienteManager.cliente.cpf}" rendered="#{clienteManager.edicao}"/>
      <h:message for="edCpf"/>

      <h:outputLabel for="edNome">
        <h:outputText value="Nome"/>
      </h:outputLabel>
      <h:inputText id="edNome" value="#{clienteManager.cliente.nome}"/>
      <h:message for="edNome"/>

      <h:commandButton value="Gravar" action="#{clienteManager.gravar}" id="gravar"/>
      <h:commandButton value="Cancelar" action="main" id="cancelar"/>

    </h:panelGrid>
  </h:form>
</f:view>
</body>
</html>
