import { useState } from "react";
import { analyzeUsage } from "../services/api";

export default function InputForm({ setRisk }) {
  const [formData, setFormData] = useState({
    screenTime: "",
    socialMediaTime: "",
    gamingTime: "",
    sleepHours: "",
    moodLevel: "",
    productivityLevel: "",
    physicalActivity: "",
  });

  // 🔹 Handle input change
  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  // 🔥 FIXED: async function
  const handleSubmit = async (e) => {
    e.preventDefault();

    const email = localStorage.getItem("userEmail");

    try {
      const res = await analyzeUsage({
        ...formData,
        email: email,
      });

      setRisk(res.data.data);
    } catch (err) {
      console.error(err);
      alert("Error connecting to backend");
    }
  };

  // 🔹 RETURN UI
  return (
    <form
      onSubmit={handleSubmit}
      className="bg-white p-6 rounded-xl shadow-lg"
    >
      <h2 className="text-xl font-bold mb-4">
        Enter Your Daily Data
      </h2>

      {/* Inputs */}
      {Object.keys(formData).map((key) => (
        <input
          key={key}
          type="number"
          name={key}
          placeholder={key}
          value={formData[key]}
          onChange={handleChange}
          className="w-full p-2 mb-3 border rounded"
        />
      ))}

      {/* Button */}
      <button className="bg-blue-500 text-white px-4 py-2 rounded w-full">
        Analyze
      </button>
    </form>
  );
}