import * as fileInfo from "./check-file-utils-1.1.js";
import * as ui from "./ui-1.1.js"
/**
 * verificar que el archivo sea correcto
 * @param dataConfig variables de configuración del módulo
 * @param dataMsg mensajes y textos en pantalla del módulo
 */
export const checkFile = (dataConfig, dataMsg) => {
    const $fileInput = document.getElementById(dataConfig.inputFileHtmlId);
    const $fileBtn = document.getElementById(dataConfig.fileBtnId);
    if(dataConfig.checkFile){
        $fileInput.addEventListener("change", element => {
            if (element.target.files.length > 0) {
                const maxFileSizeKb = dataConfig.maxFileSizeKb;
                const fileSizeKb = fileInfo.getSizeKBytes(element.target);
                const fileName = element.target.files[0].name;
                const regExp = new RegExp(dataConfig.reqFileType,  "i");
                if(!fileInfo.checkExtension(element.target, regExp)) {
                    ui.renderBtnUnlockCourse($fileBtn,false);
                    ui.notification(dataConfig.divNotifHtmlId,
                        dataConfig.spanNotifHtmlId,`
                        ${dataMsg.fileNotValid} ${fileName}`
                        , 6000);
                }else if (! fileInfo.checkSize(fileSizeKb, maxFileSizeKb)) {
                    ui.renderBtnUnlockCourse($fileBtn, false);
                    ui.notification(dataConfig.divNotifHtmlId,
                        dataConfig.spanNotifHtmlId,`
                        ${dataMsg.fileSizeNotValid}  (${fileSizeKb} Kbytes)`
                        , 6000
                    )

                }else{
                    ui.renderBtnUnlockCourse($fileBtn,true);
                }
            }
        });
    }else{
        $fileBtn.disabled = false;
    }
}

