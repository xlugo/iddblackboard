/**
 Autor: franciscoxavier.lugo@upaep.mx
 Fecha: noviembre 2021
 */
/**
 * verifica que sea una extensión de archivo válida
 * @param $file archivo
 * @param allowFileExtension expresión regular literal para extensiones de archivo permitidas
 * @returns {boolean} regresa verdadero si la extensión de archivo está permitida
 */
export  const checkExtension = ($file, allowFileExtension) => {
    let filePath = $file.value;
    return allowFileExtension.test(filePath);
}
/**
 * recupera el tamaño del archivo en KBytes
 * @param $file archivo
 * @returns {number} tamaño del archivo en Kbytes
 */
export const getSizeKBytes = ($file) => {
    const maxSizeBytes = 1024;
    const sizeByteToKBytes = 1000;
    let fileSizeBytes = $file.files.item(0).size;
    if(fileSizeBytes < maxSizeBytes){
        fileSizeBytes=maxSizeBytes;
    }
    return Math.round((fileSizeBytes / sizeByteToKBytes));
}
/**
 * verifica que el tamaño no sea mayor al permitido
 * @param fileSizeKBytes tamaño actual del archivo
 * @param fileMaxSizeKBytes tamaño máximo permitido para el archivo
 * @returns {boolean} regresa verdadero si el archivo es menor al tamaño máximo permitido
 */
export const checkSize = (fileSizeKBytes, fileMaxSizeKBytes) => {
    return fileSizeKBytes <= fileMaxSizeKBytes;
}
