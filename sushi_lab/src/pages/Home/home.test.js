import { Element } from 'react-scroll';
import { render, screen, waitFor } from "@testing-library/react"
import { BrowserRouter } from "react-router-dom"
import { ToastContainer } from "react-toastify"

import Home from "."

import { productsAction } from "../../actions/products.action"
import { productsMock } from "../../mocks/products.mock"

describe('Teste da tela Home', () => {

  it('Deve renderizar a quantidade correta de itens', async () => {

    jest.spyOn(productsAction, 'getProducts')
      .mockResolvedValue({
        data: productsMock,
        status: 200,
        statusText: "OK"
      })

    render(<Home />, { wrapper: BrowserRouter })

    await waitFor(() => {
        const productListElement = screen.getByTestId('products-list')
        expect(productListElement).toBeDefined()

    })

  })

  it('Deve exibir uma mensagem de erro na tela', async () => {
    jest.spyOn(productsAction, 'getProducts')
      .mockRejectedValue(new Error())

    render(
      <>
        <Home />
        <ToastContainer />
      </>, { wrapper: BrowserRouter })

    await waitFor(() => {
      expect(screen.getByText('Houve um erro ao retornar os produtos'))
        .toBeInTheDocument()
    })

  })
})