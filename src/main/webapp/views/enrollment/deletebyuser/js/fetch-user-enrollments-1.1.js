export const getData = async (url, formId) => {
    let $formUpload = document.getElementById(formId);
    const options = {method:"POST",
        body: new FormData($formUpload)
    };
    const response = await fetch(url, options);
    return  await response.json();
}