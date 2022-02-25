/**
 * User : franciscoxavier.lugo@upaep.mx
 * Date : 2022
 */
/**
 * oculta los elementos del DOM si no hay un archivo
 */
export const renderBtnUnlockCourse = ($fileBtn,
                                      fileIsOk) => {
    $fileBtn.disabled = !fileIsOk;
}
/**
 * muestra una notificación
 * @param divNotifHtmlId id del elemento html contenededor del mensaje
 * @param spanNotifHtmlId id del elemento html del mensaje
 * @param message mensaje a mostrar
 * @param time milisegundos que se muestra la notificación
 */
export const notification = (divNotifHtmlId,
                             spanNotifHtmlId,
                             message,
                             time) => {
    document.getElementById(divNotifHtmlId).style.display = "inline-block";
    document.getElementById(spanNotifHtmlId).innerText = message.trim();
    if(time !== 0){
        setTimeout(() => {
            document.getElementById(divNotifHtmlId).style.display = "none";
            document.getElementById(spanNotifHtmlId).innerText = "";
        }, time);
    }
}
/**
 * inicializar elementos cualquiera
 * @param dataConfig datos de configuración de la app
 */
export const  initDomElemts = (dataConfig) => {
    //document.getElementById(dataConfig.fileBtnSpanTxt).textContent = dataConfig.btnUCourseTxt;
}
/**
 *
 * @param error
 * @param cell
 * @param cuentao
 * @param cuentaf
 */
export const showIconResult = (error, cell, cuentao, cuentaf) => {
    const btn_clase = "btn btn-link";
    const icono_correcto = "bi bi-check-circle-fill";
    const icono_error = "bi bi-x-circle-fill";
    const icono_vacio = "bi bi-dash-circle";
    let $boton = document.createElement("button");
    let $icono = document.createElement("i");
    let $span = document.createElement("span");
    if(cuentao > 0){
        $span.innerText = cuentao +" de "+ cuentaf;
    }

    $boton.className = btn_clase;
    if(error){
        $icono.className = icono_error;
        $icono.style.color = "red";
    }else{
        if(cuentao == 0){
            $icono.className = icono_vacio;
            $icono.style.color = "black";
        }else{
            $icono.className = icono_correcto;
            $icono.style.color = "black";
        }
    }
    $boton.appendChild($icono);
    cell.appendChild($boton);
    cell.appendChild($span);
}

export const showDataTable = () => {
    document.getElementById("idd_div_table").style.display = "block";
};

export const showGettingMemberhips = () => {
    document.getElementById('idd_btn_exec_spinner').style.display = 'inline-block';
    document.getElementById('idd_btn_exec_txt').innerText = "Enviando..";
}

export const cleanDataTable = () => {
    let $table = document.getElementById("idd_table");
    while ($table.rows.length > 1) {
        $table.deleteRow(1);
    }
};

export const showFileLoaded = () => {
    document.getElementById("btn_exec").disabled = true;
    document.getElementById('idd_btn_exec_spinner').style.display = 'none';
    document.getElementById('idd_btn_exec_txt').innerText = "Enviar";
};