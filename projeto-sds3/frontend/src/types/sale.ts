/* VAI SEMPRE NO POSTMAN PRA PEGAR AS DEFINIÇÕES DOS OBJETOS */

import { Seller } from './seller';
export type Sale = {
    id: number;
    visited: number;
    deals: number;
    amount: number;
    date: string;
    seller: Seller;
}

/* O interrogação é OPCIONAL !!! */

export type SalePage = {
    content?: Sale[];
    last: boolean;
    totalElements: number;
    totalPages: number;
    size?: number;
    number: number;
    first: boolean;
    numberOfElements?: number;
    empty?: boolean;
}

export type SaleSum = {
    sellerName: string,
    sum: number
}

export type SaleSuccess = {
    sellerName: string;
    visited: number;
    deals: number;
}