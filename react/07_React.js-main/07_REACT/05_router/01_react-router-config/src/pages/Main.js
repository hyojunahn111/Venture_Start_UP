import { Link } from 'react-router-dom'

export default function Main(){

    return(
        <div>
            <h1>메인</h1>
            <nav>
                <Link to="/">home</Link>
                <Link to="/about">소개</Link>
                <Link to="/menu">메뉴목록</Link>
            </nav>
        </div>
    );


}
// export default Main;