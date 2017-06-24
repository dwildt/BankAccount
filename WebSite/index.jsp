<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<head>
<title>Main</title>

  <style type=text/css>
    table
    {
      background-color: #000000;
    }
    .cabecalho
    {
      BACKGROUND-COLOR: #000066;
      COLOR: #FFFFFF;
      font-family: sans-serif;
    }
    .linha1
    {
      BACKGROUND-COLOR: #FFFFFF;
      font-family: sans-serif;
    }
    .linha2
    {
      BACKGROUND-COLOR: #FFFF66;
      font-family: sans-serif;
    }

  </style>

</head>
<body bgcolor="#ffffff">
<h1>Main - Manutenção de Clientes UniRitter</h1>
<f:view>
  <h:form>


    <h:dataTable border="0" cellpadding="0" cellspacing="1"
       id="gridClientes"
       value="#{clienteManager.allClientes}"
       var="cliente"
       first="#{clienteManager.primeiro}"
       rows="#{clienteManager.pagina}"
       headerClass="cabecalho"
       rowClasses="linha1,linha2">
      <h:column>
        <f:facet name="header">
          <h:outputText id="edCpf" value="CPF"/>
        </f:facet>
        <h:commandLink
            action="#{clienteManager.editar}"
            value="#{cliente.cpf}"/>
      </h:column>
      <h:column>
        <f:facet name="header">
          <h:outputText id="edNome" value="Nome"/>
        </f:facet>
        <h:outputText value="#{cliente.nome}"/>
      </h:column>
      <h:column>
        <f:facet name="header">
          <h:outputText id="edEdit" value="Editar"/>
        </f:facet>
        <h:commandLink action="#{clienteManager.editar}" value="Editar"/>
      </h:column>
      <h:column>
        <f:facet name="header">
          <h:outputText id="edDelete" value="Remover"/>
        </f:facet>
        <h:commandLink action="#{clienteManager.remover}" value="Remover"/>
      </h:column>
    </h:dataTable>
    <h:commandButton action="#{clienteManager.incluir}" value="Incluir" id="incluir" /> |
    <h:commandButton action="#{clienteManager.doPaginaAnterior}" value="|<<|"  disabled="#{clienteManager.desabilitaBotaoAnterior}" alt="Página Anterior" id="prevPage" />
    <h:commandButton action="#{clienteManager.doPaginaProxima}" value="|>>|" disabled="#{clienteManager.desabilitaBotaoProxima}" alt="Próxima Página" id="nextPage"/> |
    <br>Clientes cadastrados: <h:outputText value="#{clienteManager.size}"/><br>
  </h:form>
</f:view>
</body>
</html>
