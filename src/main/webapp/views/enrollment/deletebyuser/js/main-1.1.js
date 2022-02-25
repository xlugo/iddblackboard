import  getContextPath from "./main-ctx-1.1.js"
import { jsonConfig
} from "./fetch-config-1.1.js";
import * as ui from  "./ui-1.1.js"
import * as user from "./get-user-enrollments-1.1.js"
const context = getContextPath();
jsonConfig(context)
    .then(jsonsConfig => {
        ui.initDomElemts(jsonsConfig[0]);
        let $btnGetMemberships = document.getElementById(jsonsConfig[0].fileBtnId);
        $btnGetMemberships.addEventListener("click", () => {
            ui.showGettingMemberhips();
            ui.cleanDataTable();
            user.getEnrollments(context,jsonsConfig[0],jsonsConfig[1])
        });
    })
    .catch(e => {
        alert(e);
    })
