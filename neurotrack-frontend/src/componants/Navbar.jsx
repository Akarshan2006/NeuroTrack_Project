import { Link, useNavigate } from "react-router-dom";

export default function Navbar() {
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("user");
    navigate("/");
  };

  return (
    <div className="flex justify-between items-center p-4 bg-white shadow">
      <h1 className="text-xl font-bold text-purple-600">NeuroTrack</h1>

      <div className="flex gap-6">
        <Link to="/dashboard" className="hover:text-blue-500">
          Dashboard
        </Link>

        <Link to="/profile" className="hover:text-blue-500">
          Profile
        </Link>

        <button
          onClick={handleLogout}
          className="bg-red-500 text-white px-3 py-1 rounded"
        >
          Logout
        </button>
      </div>
    </div>
  );
}