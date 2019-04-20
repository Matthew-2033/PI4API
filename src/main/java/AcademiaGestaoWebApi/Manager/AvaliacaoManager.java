package AcademiaGestaoWebApi.Manager;

import java.util.List;

import AcademiaGestaoWebApi.Models.RequestModels.AvaliacaoRequest;
import AcademiaGestaoWebApi.Models.ResponseModels.ApiRetorno;

public class AvaliacaoManager {

	public ApiRetorno<List<Boolean>> insertAvaliacao(AvaliacaoRequest avaliacao) {
		return new ApiRetorno<List<Boolean>>();
	}

}