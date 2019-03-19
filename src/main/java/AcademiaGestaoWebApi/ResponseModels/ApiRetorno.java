package AcademiaGestaoWebApi.ResponseModels;

import java.util.List;

/**
 *
 * @author Gabriel
 */
public class ApiRetorno<T> {

    private boolean sucess;
    private T data;
    private String mensagem;
    private List<String> errorMessages;

    public ApiRetorno() {
    }

    public ApiRetorno(boolean sucess, T data, String mensagem, List<String> errorMessages) {
        this.sucess = sucess;
        this.data = data;
        this.mensagem = mensagem;
        this.errorMessages = errorMessages;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
