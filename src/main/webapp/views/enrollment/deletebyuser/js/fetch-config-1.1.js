export const pathFileConfig = "../configs/config-1.1.json";
export const pathFileMsg = "../configs/msg-1.1.json";

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
            alert.error(error);
        });
    return data;
}















