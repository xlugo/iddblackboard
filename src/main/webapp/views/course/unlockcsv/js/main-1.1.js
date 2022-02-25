import  getContextPath from "./main-ctx-1.1.js"
import { jsonConfig
} from "./fetch-config-1.1.js";
import * as ui from  "./ui-1.1.js"
import {checkFile} from "./check-file-1.1.js";
import * as readFile from "./read-file-1.1.js"

const context = getContextPath();
jsonConfig(context)
    .then(jsonsConfig => {
        ui.initDomElemts(jsonsConfig[0]);
        checkFile(jsonsConfig[0],jsonsConfig[1]);
        let $btnUploadFile = document.getElementById(jsonsConfig[0].fileBtnId);
        $btnUploadFile.addEventListener("click", () => {
            ui.showLoadingFile();
            ui.cleanDataTable();
            readFile.unlockCourses(context, jsonsConfig[0], jsonsConfig[1]);
        });
    })
    .catch(e => {
        alert(e);
    })
