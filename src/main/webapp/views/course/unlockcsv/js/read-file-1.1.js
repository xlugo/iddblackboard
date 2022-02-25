import * as fetchFile from "./fetch-read-file-1.1.js";
import * as fetchCourse from "./fetch-unlock-course-1.1.js";
import * as ui from  "./ui-1.1.js";
export const unlockCourses = (context, jsonsConfig, jsonsMessages) => {
    fetchFile.getData(`${context}/${jsonsConfig.fileUploadController}`,`${jsonsConfig.fileFormId}`)
        .then(data => {
            ui.showFileLoaded();
            ui.showDataTable();
            ui.notification(jsonsConfig.divNotifHtmlId,
                jsonsConfig.spanNotifHtmlId,`
                        ${jsonsMessages.unlocking} ${data.coursesid.length} ${jsonsMessages.courses}`
                , 0);
            let courseIds = [];
            let urls=[];
            courseIds = data.coursesid;
            courseIds.forEach(item => {
                //urls.push("desbloq.jsp?courseid="+item);
                urls.push(`${context}/${jsonsConfig.unlockCourseController}?courseid=${item}`);
            });
            fetchCourse.unLockParallel(urls)
                .then(r => {
                    ui.notification(jsonsConfig.divNotifHtmlId,
                        jsonsConfig.spanNotifHtmlId,`
                        ${jsonsMessages.unlocked} ${data.coursesid.length} ${jsonsMessages.courses}`
                        , 0);
                }).catch(e => {
                    alert(e);
                });
        }).catch(e => {
            alert(e);
        });
}

