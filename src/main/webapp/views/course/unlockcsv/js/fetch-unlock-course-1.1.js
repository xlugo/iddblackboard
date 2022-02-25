import * as ui from "./ui-1.1.js"


export async function unLockParallel(urls) {
    // fetch all the URLs in parallel
    const jsonPromises = urls.map(async url => {
            const response = await fetch(url);
            if(!response.ok){
                let jsonStr = `{"error":true,"mensaje":"error en response de fetch (${response.status}), ${response.statusText}"}`;
                return JSON.parse(jsonStr);
            }
            return response.json();
        }
    );

    // log them in sequence´
    //row.className = "table-warning";cell_0.colSpan = 4
    let conta=0;
    for (const jsonPromise of jsonPromises) {
        try{
            const data = await jsonPromise;
            const tbody = document.getElementById("idd_table_tbody");
            const row = tbody.insertRow(-1);
            row.id = "idd_curso_raw_" + conta;
            const cell_0 = row.insertCell(0);
            cell_0.innerHTML =  data.course.courseid;
            const cell_1 = row.insertCell(1);
            ui.showIconResult(data.course.error, cell_1, -1, -1);
            const cell_2 = row.insertCell(2);
            ui.showIconResult(data.enrollment.error, cell_2, data.enrollment.cuentao, data.enrollment.cuentaf);
            const cell_3 = row.insertCell(3);
            ui.showIconResult(data.person.error, cell_3, data.person.cuentao, data.person.cuentaf);
            ++conta;
            console.log('(#'+ conta +')'+JSON.stringify(data));
        }catch(error){
            console.log('(#'+ conta +')'+error);
        }
    }
    console.log(`se procesaron  ${conta} de ${urls.length} cursos`);

}