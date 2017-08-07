package domain.commands

import android.content.Context
import data.CurrencyRequest
import domain.mappers.CurrencyDataMapper
import domain.model.Currency

/***********************************************************************************************************************
 * Created by Anartz Mugika on 22/07/2017.
 * ---------------------------------------------------------------------------------------------------------------------
 * Está clase es la encargada de hacer la llamada a CurrenCyRequest donde tendremos la información
 * de la URL, parámetros necesarios para obtener la información requerida de la api. Al obtener la información
 * de CurrencyRequest, usamos dicha información en CurrencyDataMapper para "modelarlo" como nosotros queramos y
 * conseguir esa información a nuestro gusto, gestionando la información dentro de las funciones que definamos
 * como es el caso de convertFromDataModel
 ***********************************************************************************************************************/
class RequestCurrencyCommand(val baseMoney: String, val context: Context): Command<Currency> {
    override fun execute(): Currency {
        return CurrencyDataMapper().convertFromDataModel(CurrencyRequest(baseMoney).execute(context));
    }
}