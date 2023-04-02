import { render, screen } from "@testing-library/react"
import Menu from "."

describe('Testar o componente de menu', () => {

  it('Deve renderizar o menu corretamente', () => {
    render(<Menu />)

    expect(screen.getByText('Menu')).toBeInTheDocument()
    expect(screen.getByText('Carrinho - 0 items')).toBeInTheDocument()
  })
})