export const pathFileConfig = "configs/course/unlockcsv/config-1.1.json";
export const pathFileMsg = "configs/course/unlockcsv/msg-1.1.json";

export const jsonConfig = async (context) => {
    let settingUrls = [
        `${context}/${pathFileConfig}`,
        `${context}/${pathFileMsg}`
    ]
   const data = await Promise.all(settingUrls.map(async url => {
        const responses = await fetch(url);
        return responses.json();
    }))
        .catch(error => {
            console.error(error);
        });
    return data;
}















