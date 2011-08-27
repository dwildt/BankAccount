package com.facensa.bank.jsfmanager;

import java.sql.SQLException;
import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.facensa.bank.model.ClienteDAO;
import com.facensa.bank.model.ClienteDTO;

public class ClienteManager {

    private boolean edicao;

    private static ClienteDAO clienteDao = new ClienteDAO();

    private ClienteDTO cliente = null;

    private DataModel clienteModel;

    private List listaClientes;

    private int primeiro;

    private int pagina;

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(int primeiro) {
        this.primeiro = primeiro;
    }

    public ClienteManager() {
        super();
        primeiro = 0;
        pagina = 3;
        setEdicao(false);
    }

    public void setCategoria(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public ClienteDTO getCliente() {
        if (cliente == null) {
            cliente = new ClienteDTO();
        }
        return cliente;
    }

    public DataModel getAllClientes() {
        if (clienteModel == null) {
            clienteModel = new ListDataModel();
        }

        listaClientes = selectAllClientes();

        clienteModel.setWrappedData(listaClientes);
        return clienteModel;
    }

    /**
     * selectAllClientes
     *
     * @return List
     */
    private List selectAllClientes() {
        List retorno = null;
        retorno = clienteDao.getAll();
        return retorno;
    }

    public String editar() {
        ClienteDTO categoriaLocal = (ClienteDTO) clienteModel.getRowData();
        setCategoria(categoriaLocal);
        setEdicao(true);
        return "editaCliente";
    }

    public String remover() {
        ClienteDTO clienteLocal = (ClienteDTO) clienteModel.getRowData();
        try {
            clienteDao.remover(clienteLocal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clienteLocal = null;
        return "main";
    }

    public String incluir() {
        setCategoria(null);
        setEdicao(false);
        //System.out.println("entrou para incluir");
        return "incluiCliente";
    }

    public String atualizarCategoria() {
        return "main";
    }

    public String gravar() {
        try {
            clienteDao.inserir(cliente);
            setEdicao(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "main";
    }

    public boolean getDesabilitaBotaoProxima() {
        return!((primeiro + pagina) < listaClientes.size());
    }

    public boolean getDesabilitaBotaoAnterior() {
        return!((primeiro - pagina) >= 0);
    }


    public String doPaginaProxima() {
        if ((primeiro + pagina) < listaClientes.size()) {
            primeiro += pagina;
        }
        return null;
    }

    public String doPaginaAnterior() {
        primeiro -= pagina;
        if (primeiro < 0) {
            primeiro = 0;
        }
        return null;
    }

    public ClienteDAO getCategoriaDao() {
        return clienteDao;
    }

    public void setCategoriaDao(ClienteDAO clienteDao) {
        this.clienteDao = clienteDao;
    }

    public void setEdicao(boolean edicao) {
        this.edicao = edicao;
    }

    public boolean getEdicao() {
        return edicao;
    }

    public int getSize()
    {
        return listaClientes.size();
    }

}
