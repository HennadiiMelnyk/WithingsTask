package com.melnyk.withingstasks.task1;

public class Searcher {

    /**
     * Method to find the first index of the non-encoded String contained in the encoded String
     * @param encoded    string encoded in UTF-8
     * @param nonEncoded string
     * @return index
     */
    public int findIndexOfCharFromNonEncodedString(String encoded, String nonEncoded) {
        byte[] nonEncodedBytes = nonEncoded.getBytes();
        String[] arr = encoded.split(" ");
        byte[] encodedBytes = new byte[arr.length];
        for(int i = 0; i < arr.length; i++){
            encodedBytes[i] = Byte.parseByte(arr[i], 16);
        }
        for (int i = 0; i < encodedBytes.length; i++) {
            for (int j = 0; j < nonEncodedBytes.length - 1; j++)
                if (encodedBytes[i] == nonEncodedBytes[j]) {
                    return i;
                }
        }
        return 0;
    }
}
