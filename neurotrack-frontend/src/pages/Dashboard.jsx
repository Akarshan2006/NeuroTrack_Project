import Navbar from "../componants/Navbar";
import InputForm from "../componants/InputForm";
import RiskCard from "../componants/RiskCard";
import { useState } from "react";

export default function Dashboard() {
  const [risk, setRisk] = useState("");

  return (
    <div>
      <Navbar />

      <div className="p-6 grid grid-cols-1 md:grid-cols-2 gap-6">
        <InputForm setRisk={setRisk} />

        {risk && <RiskCard risk={risk} />}
      </div>
    </div>
  );
}